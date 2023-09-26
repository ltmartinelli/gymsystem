import { UnitDTO } from '../../models/unit'
import gymimg from '../../assets/gym.avif'
import './styles.css'

type Props = {
    unit: UnitDTO
}

export default function UnitCard({ unit }: Props)
{
    return (
        <div className='gs-unit-card'>
            <h1>{unit.name}</h1>
            <img src={gymimg} alt={unit.name} />
            <strong><address>{`${unit.address.street}, Nº ${unit.address.number}, ${unit.address.state}`} <br /> {`CEP: ${unit.address.zip}`}</address></strong>
        </div>
    )
}