import { useEffect, useState } from 'react'
import './styles.css'
import axios from 'axios'
import PlanCard from '../PlanCard'
import { PlanDTO } from '../../models/plan'

export default function Plans()
{

    const [plans, setPlans] = useState<PlanDTO[]>([])

    useEffect(() =>
    {
        axios.get("http://localhost:8080/plans").then(response => setPlans(response.data))
    },
        []
    )

    return (
        <section className="gs-section-plans">

            <h1 className='gs-section-plans-title'> Planos </h1>

            <div className='gs-plans-container'>
                {
                    plans.map(plan =>
                        <PlanCard key={plan.id} plan={plan} />
                    )
                }
            </div>

        </section>
    )
}