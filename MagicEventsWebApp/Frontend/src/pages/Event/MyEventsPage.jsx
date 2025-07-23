import { useEffect, useState } from 'react';
import { getEventsc, getEventsp } from '../../api/eventAPI';
import { mapEventDTOtoCardProps } from '../../utils/eventObjectMapping';
import EventList from '../../components/lists/EventList';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCalendarPlus, faBoxArchive } from '@fortawesome/free-solid-svg-icons';
import { NavLink } from 'react-router-dom';
import Button from '../../components/buttons/Button';

const MyEventsPage = () => {
	const [createdEvents, setCreatedEvents] = useState([]);
	const [participatedEvents, setParticipatedEvents] = useState([]);
	const [ongoingEvents, setOngoingEvents] = useState([]);
	const [ready, setReady] = useState(false);
	const [loading, setLoading] = useState(true);

	useEffect(() => {
		setReady(false);
		setLoading(true);
		async function fetchAPI() {
			try {
				const [createdRes, participatedRes] = await Promise.all([getEventsc(), getEventsp()]);

				if (!createdRes.ok || !participatedRes.ok) {
					console.log(createdRes, participatedRes);
					setCreatedEvents([]);
					setParticipatedEvents([]);
					setOngoingEvents([]);
					setReady(true);
					return;
				}

				const [createdData, participatedData] = await Promise.all([
					createdRes.json(),
					participatedRes.json(),
				]);

				const mappedCreatedEvents = await createdData.map(mapEventDTOtoCardProps);
				const mappedParticipatedEvents = await participatedData.map(mapEventDTOtoCardProps);

				 // Separate past and ongoing/upcoming events
				const now = new Date();
				const pastEvents = mappedParticipatedEvents.filter(event => new Date(event.date) < now);
				const ongoingOrUpcomingEvents = mappedParticipatedEvents.filter(event => new Date(event.date) >= now);

				// Sort events by date (most recent first for past events, ascending for ongoing/upcoming)
				pastEvents.sort((a, b) => new Date(b.date) - new Date(a.date));
				ongoingOrUpcomingEvents.sort((a, b) => new Date(a.date) - new Date(b.date));

				setCreatedEvents(mappedCreatedEvents);
				setParticipatedEvents(pastEvents);
				setOngoingEvents(ongoingOrUpcomingEvents);
				setReady(true);
			} catch (error) {
				console.error('Error fetching events:', error);
				setCreatedEvents([]);
				setParticipatedEvents([]);
				setOngoingEvents([]);
				setReady(true);
			} finally {
				setLoading(false);
			}
		}
		fetchAPI();
	}, []);

	return (
		<div className="h-full overflow-y-auto bg-gradient-to-br from-[#505458] to-[#363540]">
			{/* Header Section */}
			<div className="bg-gradient-to-r from-[#EE0E51] to-[#ff4574] p-3 sm:p-6 shadow-lg">
				<div className="max-w-6xl mx-auto">
					<div className="flex flex-col gap-3 sm:gap-4 sm:flex-row sm:items-center sm:justify-between">
						<div className="flex items-center gap-3 sm:gap-4">
							<div className="p-2 sm:p-3 bg-white bg-opacity-20 rounded-full">
								<FontAwesomeIcon icon={faBoxArchive} className="text-lg sm:text-2xl text-[#505458]" />
							</div>
							<div>
								<h1 className="text-xl sm:text-3xl font-bold text-white">I Miei Eventi</h1>
								<p className="text-sm sm:text-base text-white text-opacity-90">Gestisci tutti i tuoi eventi</p>
							</div>
						</div>
						
						<NavLink to="/newevent" className="w-full sm:w-auto">
							<Button 
								text={
									<div className="flex items-center justify-center gap-2">
										<FontAwesomeIcon icon={faCalendarPlus} />
										<span>Crea Evento</span>
									</div>
								}
								custom="w-full sm:w-auto bg-white text-[#EE0E51] hover:bg-gray-100 border-white hover:border-gray-100 font-semibold px-4 py-2 sm:px-6 sm:py-3 text-sm sm:text-base"
							/>
						</NavLink>
					</div>
				</div>
			</div>

			{/* Content */}
			<div className="p-3 sm:p-4 md:p-6">
				<div className="max-w-6xl mx-auto">
					{loading ? (
						<div className="flex flex-col items-center justify-center py-16">
							<div className="animate-spin rounded-full h-16 w-16 border-4 border-[#E4DCEF] border-t-[#EE0E51] mb-4"></div>
							<p className="text-[#E4DCEF] text-lg font-medium">Caricamento eventi...</p>
						</div>
					) : ready ? (
						<>
							{/* Created Events Section */}
							{createdEvents.length > 0 ? (
								<div className="bg-white bg-opacity-20 backdrop-blur-sm rounded-2xl p-2 shadow-xl mb-8">
									<h2 className="text-xl font-bold text-[#E4DCEF] mb-4">Eventi Creati</h2>
									<EventList events={createdEvents} />
								</div>
							) : (
								<div className="text-center py-8">
									<p className="text-[#E4DCEF] text-lg">Non hai creato ancora nessun evento</p>
								</div>
							)}

							 {/* Ongoing/Upcoming Events Section */}
							{ongoingEvents.length > 0 ? (
								<div className="bg-white bg-opacity-20 backdrop-blur-sm rounded-2xl p-2 shadow-xl mb-8">
									<h2 className="text-xl font-bold text-[#E4DCEF] mb-4">Eventi in Corso</h2>
									<EventList events={ongoingEvents} />
								</div>
							) : (
								<div className="text-center py-8">
									<p className="text-[#E4DCEF] text-lg">Non ci sono eventi in corso</p>
								</div>
							)}

							{/* Participated Events Section */}
							{participatedEvents.length > 0 ? (
								<div className="bg-white bg-opacity-20 backdrop-blur-sm rounded-2xl p-2 shadow-xl">
									<h2 className="text-xl font-bold text-[#E4DCEF] mb-4">Eventi a cui ho partecipato</h2>
									<EventList
										events={participatedEvents}
										customRender={(event) => (
											<div className="p-4 rounded-lg bg-gray-500 text-white">
												{event.title} - {event.date}
											</div>
										)}
									/>
								</div>
							) : (
								<div className="text-center py-8">
									<p className="text-[#E4DCEF] text-lg">Non hai partecipato a nessun evento</p>
								</div>
							)}
						</>
					) : (
						<div className="text-center py-16">
							<div className="text-red-400 mb-4">
								<FontAwesomeIcon icon={faBoxArchive} className="text-6xl opacity-50" />
							</div>
							<p className="text-[#E4DCEF] text-lg">Errore nel caricamento degli eventi</p>
							<Button 
								text="Riprova"
								onClick={() => window.location.reload()}
								custom="mt-4 px-4 py-2 sm:px-6 sm:py-2 text-sm sm:text-base"
							/>
						</div>
					)}
				</div>
			</div>
		</div>
	);
};

export default MyEventsPage;
