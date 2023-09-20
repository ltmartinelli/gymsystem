import { useEffect, useState } from 'react';
import WorkoutCard from '../../../../components/WorkoutCard';
import './styles.css'
import { WorkoutDTO } from '../../../../models/workout';
import { findWorkoutsByUser } from '../../../../services/workout-service';


export default function Workouts()
{

    const [workouts, setWorkouts] = useState<WorkoutDTO[]>([]);

    useEffect(() =>
    {
        findWorkoutsByUser().then(response => setWorkouts(response.data.content))
    }
        ,
        []
    )

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
        </main>
    );
}