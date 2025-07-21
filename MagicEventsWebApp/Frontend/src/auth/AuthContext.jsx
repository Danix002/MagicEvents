import React, { createContext, useContext, useEffect } from 'react';
import {logout, refreshToken } from '../api/userAPI';

const AuthContext = createContext();

const REFRESH_INTERVAL_MINUTES = 5;

export const AuthProvider = ({ children, user, setUser }) => {
  const navigate = useNavigate();

  useEffect(() => {
    if (!user?.refreshToken) return;

    const refresh = async () => {
      try {
        const res = await refreshToken(user.refreshToken);

        if (!res.ok) throw new Error('Refresh token failed');

        const data = await res.json();
        console.log("Call refresh:", data);
        setUser(prev => {
          const updatedUser = {
            ...prev,
            token: data.accessToken,
            refreshToken: data.refreshToken,
            expirationTime: data.expirationTime,
          };
          sessionStorage.setItem('user', JSON.stringify(updatedUser));
          return updatedUser;
        });
      } catch (err) {
        console.error('Refresh token failed:', err);
        try {
          const res = await logout();

          if (!res.ok) throw new Error('Logout failed');

          setUser(null);
          sessionStorage.removeItem('user');
        } catch (logoutErr) {
          console.error('Logout failed:', logoutErr.message);
        }
      }
    };

    const interval = setInterval(refresh, REFRESH_INTERVAL_MINUTES * 60 * 1000);
    return () => clearInterval(interval);
  }, [user?.refreshToken]);

  return <AuthContext.Provider value={{}}>{children}</AuthContext.Provider>;
};

export const useAuth = () => useContext(AuthContext);
