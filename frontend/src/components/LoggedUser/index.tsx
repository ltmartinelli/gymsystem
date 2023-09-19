import { Link, useNavigate } from 'react-router-dom';
import * as authService from '../../services/auth-service.ts'
import { useContext } from 'react';
import { ContextToken } from '../../utils/context-token.ts';

export default function LoggedUser()
{
    const { contextTokenPayload, setContextTokenPayload } = useContext(ContextToken);
    const navigate = useNavigate();

    function handleLogoutClick()
    {
        authService.logout();
        setContextTokenPayload(undefined);
        navigate("/login");
    }

    return (
        contextTokenPayload && authService.isAuthenticated() ?
            (
                <div className="gs-logged-user">
                    <p>{contextTokenPayload.user_name}</p>
                    <Link to='/me'>
                        <h2>Meu Perfil</h2>
                    </Link>
                    <span onClick={handleLogoutClick}>Sair</span>
                </div>
            )
            :
            (
                <Link to="/login">
                    Login
                </Link>
            )
    );
}