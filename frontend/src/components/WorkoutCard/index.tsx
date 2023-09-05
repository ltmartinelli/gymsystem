import './styles.css'

export default function WorkoutCard()
{
    return (
        <div className="gs-workout-card">
            <h1> TREINO A </h1>
            <table className="gs-workout-table">
                <thead>
                    <tr>
                        <th>Exercício</th>
                        <th>Sets</th>
                        <th>Repetições</th>
                        <th>Carga</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Exercício 1</td>
                        <td>3</td>
                        <td>12</td>
                        <td>8</td>
                    </tr>
                    <tr>
                        <td>Exercício 2</td>
                        <td>3</td>
                        <td>12</td>
                        <td>8</td>
                    </tr>
                    <tr>
                        <td>Exercício 3</td>
                        <td>3</td>
                        <td>12</td>
                        <td>8</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}