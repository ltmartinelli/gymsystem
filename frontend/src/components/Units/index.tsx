import UnitCard from '../UnitCard'
import './styles.css'

export default function Units()
{
    return (
        <section className="gs-section-units">

            <h1 className='gs-section-units-title'> Unidades</h1>

            <div className='gs-units-container'>
                <UnitCard />
                <UnitCard />
                <UnitCard />
                <UnitCard />
            </div>

        </section>
    )
}