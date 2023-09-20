import { useEffect, useState } from 'react';
import WorkoutCard from '../../../../components/WorkoutCard';
import './styles.css'
import { WorkoutDTO } from '../../../../models/workout';
import { findWorkoutsByUser } from '../../../../services/workout-service';
import DialogConfirmation from '../../../../components/DialogConfirmation';


export default function Workouts()
{

    const [workouts, setWorkouts] = useState<WorkoutDTO[]>([]);

    const [dialogConfirmationData, setDialogConfirmationData] = useState({
        visible: true,
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
        /* if (answer)
        {
            workoutService.deleteById(workoutId)
                .then(() =>
                {
                    setWorkouts([]);
                    setQueryParams({ ...queryParams, page: 0 });
                })
                .catch(error => setDialogInfoData({ visible: true, message: error.response.data.error }));
        }
        */
        setDialogConfirmationData({ ...dialogConfirmationData, visible: false });
    }


    return (
        <main className="gs-container">
            <section className="gs-workouts-section">
                <h1 className='gs-workouts-section-title'>MEUS TREINOS</h1>
                <div className='gs-workouts-cards-container'>
                    {
                        workouts.map(workout => (
                            <WorkoutCard key={workout.id} workout={workout} />
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