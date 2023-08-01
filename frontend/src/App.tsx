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
          </Route>

          <Route path="/admin/" element={<PrivateRoute roles={['ROLE_ADMIN']}><h1>Admin</h1></PrivateRoute>}>

          </Route>

          <Route path="*" element={<Navigate to="/" />} />

        </Routes>
      </HistoryRouter>
    </ContextToken.Provider>
  )
}

export default App
