import './styles.css'

export default function Users()
{
    return (
        <section className="gs-users-section">
            <table className="gs-users-table">
                <thead>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Unidade</th>
                </thead>
                <tbody>
                    <tr>
                        <td>Fulano</td>
                        <td>fulano@gmail.com</td>
                        <td>unidade</td>
                    </tr>
                    <tr>
                        <td>Fulano</td>
                        <td>fulano@gmail.com</td>
                        <td>unidade</td>
                    </tr>
                    <tr>
                        <td>Fulano</td>
                        <td>fulano@gmail.com</td>
                        <td>unidade</td>
                    </tr>
                    <tr>
                        <td>Fulano</td>
                        <td>fulano@gmail.com</td>
                        <td>unidade</td>
                    </tr>
                </tbody>
            </table>
        </section>
    );
}