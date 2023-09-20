import { WorkoutDTO } from '../../models/workout';
import './styles.css'

type Props = {
    workout: WorkoutDTO
    onDeleteClick: (workoutId: number) => void
    onEditClick: (workoutId: number) => void
}

export default function WorkoutCard({ workout, onDeleteClick, onEditClick }: Props)
{
    return (
        <div className="gs-workout-card">
            <h1 className='gs-workout-card-title'> {workout.name} </h1>
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
            <div className='gs-workout-card-btn-container'>
                <button onClick={() => onDeleteClick(workout.id)} className='gs-dialog-btn-no'>DELETAR</button>
                <button onClick={() => onEditClick(workout.id)} className='gs-dialog-btn-yes'>EDITAR</button>
            </div>
        </div>
    );
}