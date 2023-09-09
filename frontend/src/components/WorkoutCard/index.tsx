import { WorkoutDTO } from '../../models/workout';
import './styles.css'

type Props = {
    workout: WorkoutDTO
}

export default function WorkoutCard({ workout }: Props)
{
    return (
        <div className="gs-workout-card">
            <h1> {workout.name} </h1>
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

                    {
                        workout.exercises.map(exercise => (
                            <tr key={exercise.id}>
                                <td>{exercise.name}</td>
                                <td>{exercise.sets}</td>
                                <td>{exercise.reps}</td>
                                <td>{exercise.weight} kg</td>
                            </tr>
                        )
                        )
                    }

                </tbody>
            </table>
        </div>
    );
}