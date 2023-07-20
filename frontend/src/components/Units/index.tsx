import { useEffect, useState } from 'react'
import { UnitDTO } from '../../models/unit'
import UnitCard from '../UnitCard'
import './styles.css'
import axios from 'axios'

export default function Units()
{

    const [units, setUnits] = useState<UnitDTO[]>([])

    useEffect(() =>
    {
        axios.get("http://localhost:8080/units").then(response => setUnits(response.data))
    },
        []
    )

    return (
        <section className="gs-section-units">

            <h1 className='gs-section-units-title'> Unidades</h1>

            <div className='gs-units-container'>
                {
                    units.map(unit =>
                        <UnitCard key={unit.id} unit={unit} />
                    )
                }
            </div>

        </section>
    )
}