import './index.css'
import { unstable_HistoryRouter as HistoryRouter, Navigate, Route, Routes } from 'react-router-dom';
import ClientHome from './routes/Client/ClientHome'
import HomePage from './routes/Client/ClientHome/HomePage'
import Login from './routes/Client/Login'
import * as authService from './services/auth-service.ts';
import { ContextToken } from './utils/context-token.ts';
import { history } from './utils/history';
import { useEffect, useState } from 'react';
import { AccessTokenPayloadDTO } from './models/auth.ts';
import { PrivateRoute } from './components/PrivateRoute/index.tsx';
import Workouts from './routes/Client/ClientHome/Workouts/index.tsx';
import Me from './routes/Client/ClientHome/Me/index.tsx';
import Users from './routes/Admin/Users/index.tsx';
import WorkoutForm from './routes/Client/ClientHome/WorkoutForm/index.tsx';

function App()
{

  const [contextTokenPayload, setContextTokenPayload] = useState<AccessTokenPayloadDTO>();

  useEffect(() =>
  {
    if (authService.isAuthenticated())
    {
      const payload = authService.getAccessTokenPayload();
      setContextTokenPayload(payload);
    }
  }, []);

  return (
    <ContextToken.Provider value={{ contextTokenPayload, setContextTokenPayload }}>
      <HistoryRouter history={history}>
        <Routes>

          <Route path='/' element={<ClientHome />}>
            <Route index element={<HomePage />} />
            <Route path="login" element={<Login />} />
            <Route path="workouts" element={<PrivateRoute roles={['ROLE_ADMIN', 'ROLE_CLIENT']}><Workouts /></PrivateRoute>} />
            <Route path="workouts/:workoutId" element={<PrivateRoute roles={['ROLE_ADMIN', 'ROLE_CLIENT']}><WorkoutForm/></PrivateRoute>} />
            <Route path="me" element={<PrivateRoute roles={['ROLE_ADMIN', 'ROLE_CLIENT']}><Me /></PrivateRoute>} />
          </Route>

          <Route path="/admin/" element={<PrivateRoute roles={['ROLE_ADMIN']}><ClientHome /></PrivateRoute>}>
            <Route index element={<Navigate to="/admin/users"/>} />
            <Route path="users/" element={<Users/>} />
          </Route>

          <Route path="*" element={<Navigate to="/" />} />

        </Routes>
      </HistoryRouter>
    </ContextToken.Provider>
  )
}

export default App
