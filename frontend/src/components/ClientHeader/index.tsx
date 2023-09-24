import { useContext } from 'react';
import './styles.css'
import { ContextToken } from '../../utils/context-token';
import { Link } from 'react-router-dom';
import LoggedUser from '../LoggedUser';
import * as authService from '../../services/auth-service.ts'

export default function ClientHeader()
{

    const { contextTokenPayload } = useContext(ContextToken);

    return (
        <header className='gs-header-client'>
            <Link to='/'>
                <h1 className='gs-header-title'>GymSystem</h1>
            </Link>
            {
                contextTokenPayload && authService.isAuthenticated() ?
                <Link to='/workouts/'>
                    <h1>Treinos</h1>
                </Link>
                :
                <></>
            }
            {
                contextTokenPayload && authService.isAuthenticated() && authService.hasAnyRoles(["ROLE_ADMIN"]) ?
                <Link to='/admin/users'>
                    <h1>Usuários</h1>
                </Link>
                :
                <></>
            }
            <LoggedUser/>
        </header>
    )
}