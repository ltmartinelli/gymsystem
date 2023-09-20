import { useEffect, useState } from 'react';
import WorkoutCard from '../../../../components/WorkoutCard';
import './styles.css'
import { WorkoutDTO } from '../../../../models/workout';
import { findWorkoutsByUser, deleteById } from '../../../../services/workout-service';
import DialogConfirmation from '../../../../components/DialogConfirmation';


export default function Workouts()
{

    const [workouts, setWorkouts] = useState<WorkoutDTO[]>([]);

    const [dialogConfirmationData, setDialogConfirmationData] = useState({
        visible: false,
        message: "Tem certeza?",
        id: 0,
    });

    useEffect(() =>
    {
        findWorkoutsByUser().then(response => setWorkouts(response.data.content))
    }
        ,
        []
    )

    function handleDialogConfirmationAnswer(answer: boolean, workoutId: number)
    {
        if (answer)
        {
            deleteById(workoutId)
                .then(() =>
                {
                    findWorkoutsByUser().then(response => setWorkouts(response.data.content))
                })
                //.catch(error => setDialogInfoData({ visible: true, message: error.response.data.error }));
        }
        setDialogConfirmationData({ ...dialogConfirmationData, visible: false });
    }

    function handleDeleteClick(workoutId: number)
    {
        setDialogConfirmationData({ ...dialogConfirmationData, visible: true, id: workoutId });
    }

    return (
        <main className="gs-container">
            <section className="gs-workouts-section">
                <h1 className='gs-workouts-section-title'>MEUS TREINOS</h1>
                <div className='gs-workouts-cards-container'>
                    {
                        workouts.map(workout => (
                            <WorkoutCard key={workout.id} workout={workout} onDeleteClick={handleDeleteClick} />
                        )
                        )
                    }
                </div>
            </section>
            {
                dialogConfirmationData.visible &&
                <DialogConfirmation
                    id={dialogConfirmationData.id}
                    message={dialogConfirmationData.message}
                    onDialogAnswer={handleDialogConfirmationAnswer} />
            }
        </main>
    );
}