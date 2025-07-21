import { useEffect } from 'react';
import {useLocation, useNavigate} from 'react-router-dom';
import { useAuth } from '../../auth/AuthContext';
import { callback } from '../../api/userAPI';

function GoogleCallbackPage({ setLogged }) {
	const location = useLocation();
	const from = sessionStorage.getItem('fromAfterLogin') || location.state?.from || '/home';
	const navigate = useNavigate();
	const { setUser } = useAuth();

	useEffect(() => {
		const handleCallback = async () => {
			const urlParams = new URLSearchParams(window.location.search);
			const accessToken = urlParams.get('accessToken');
			if (!accessToken) {
				console.error('Missing access token');
				navigate('/login', { replace: true });
				return;
			}
			try {
				const res = await callback(accessToken);

				if (!res.ok) throw new Error('User not found');

				const data = await res.json();

				if (!data.token) {
					console.error('Invalid token');
					navigate('/login', { replace: true });
					return;
				}

				setUser(data);
				sessionStorage.setItem('user', JSON.stringify(data));

				setLogged(true);
				navigate(from, { replace: true });
				sessionStorage.removeItem('fromAfterLogin');
			} catch (err) {
				console.error('Error:', err.message);
				navigate('/login', { replace: true });
			}
		};

		handleCallback();
	}, [navigate, setUser]);

	return <p style={{ textAlign: 'center' }}>Processing...</p>;
}

export default GoogleCallbackPage;
