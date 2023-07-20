import { UnitDTO } from '../../models/unit'
import UnitCard from '../UnitCard'
import './styles.css'

export default function Units()
{

    const mockUnit: UnitDTO = {
        id: 1,
        name: "PowerGym Porto Alegre",
        address: {
            id: 1,
            state: "RS",
            city: "Porto Alegre",
            street: "Rua Borges de Medeiros",
            number: 200,
            zip: "90020-025",
            unitId: 1
        }
    }

    return (
        <section className="gs-section-units">

            <h1 className='gs-section-units-title'> Unidades</h1>

            <div className='gs-units-container'>
                <UnitCard unit={mockUnit}/>
                <UnitCard unit={mockUnit}/>
                <UnitCard unit={mockUnit}/>
                <UnitCard unit={mockUnit}/>
            </div>

        </section>
    )
}