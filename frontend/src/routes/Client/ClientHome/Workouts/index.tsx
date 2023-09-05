import WorkoutCard from '../../../../components/WorkoutCard';
import './styles.css'

export default function Workouts()
{
    return (
        <main className="gs-container">
            <section className="gs-workouts-section">
                <h1>MEUS TREINOS</h1>
                <div className='gs-workouts-cards-container'>
                    <WorkoutCard />
                    <WorkoutCard />
                    <WorkoutCard />
                </div>
            </section>
        </main>
    );
}