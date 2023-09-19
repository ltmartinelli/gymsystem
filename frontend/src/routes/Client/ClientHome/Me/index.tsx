import { useEffect, useState } from "react";
import { UserDTO } from "../../../../models/user";
import { findMe } from "../../../../services/user-service";
import './styles.css'

export default function Me()
{

    const [userData, setUserData] = useState<UserDTO>();

    useEffect(() =>
    {
        findMe().then(response => setUserData(response.data))
    },
        []
    )

    return (
        <main>
            <section className="gs-profile-section">
                <h1>Perfil</h1>
                {
                    userData &&
                    <div className="gs-profile-card">
                    <p><strong>Nome: </strong>{userData.name}</p>
                    <p><strong>E-Mail: </strong>{userData.email}</p>
                    <p><strong>Telefone: </strong>{userData.phone}</p>
                    <p><strong>Data de Nascimento: </strong>{userData.birthDate.replace(/-/g,'/')}</p>
                    <p><strong>Endereço: </strong>{userData.address.street}, {userData.address.number}, {userData.address.state}</p>
                    <p><strong>CEP: </strong>{userData.address.zip}</p>
                    <p><strong>Unidade: </strong>{userData.unit.name}</p>
                    </div>
                }

            </section>
        </main>
    );
}