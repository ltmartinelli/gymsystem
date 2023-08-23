import { useContext } from 'react';
import './styles.css'
import { ContextToken } from '../../utils/context-token';
import { Link } from 'react-router-dom';
import LoggedUser from '../LoggedUser';

export default function ClientHeader()
{

    const { contextTokenPayload } = useContext(ContextToken);

    return (
        <header className='gs-header-client'>
            <Link to='/'>
                <h1 className='gs-header-title'>GymSystem</h1>
            </Link>
            <LoggedUser/>
        </header>
    )
}