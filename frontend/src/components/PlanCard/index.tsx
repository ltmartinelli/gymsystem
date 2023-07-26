import { PlanDTO } from '../../models/plan'
import './styles.css'

type Props = {
    plan: PlanDTO
}

export default function PlanCard({ plan }: Props)
{
    return (
        <div className='gs-plan-card'>
            <h1>{plan.name}</h1>
            <p>{plan.description}</p>
            <p>R$ {plan.price.toFixed(2)}</p>
        </div>
    )
}