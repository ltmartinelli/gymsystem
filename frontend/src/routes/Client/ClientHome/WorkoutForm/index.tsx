import { useNavigate, useParams } from "react-router-dom";
import FormInput from "../../../../components/FormInput";
import './styles.css'

export default function WorkoutForm()
{

    const params = useParams();

    const navigate = useNavigate();

    const isEditing = params.productId !== 'create';

    //NOVO TREINO OU EDITAR TREINO DEPENDENDO DO isEDITING

    return (

        <main className="gs-container">
            <section className="gs-workout-form-section">
                <form className="gs-form">
                    {isEditing ? <h1>Novo Treino</h1> : <h1>Editar</h1>}
                    <div className="gs-workout-form-card">
                        
                        <div className="gs-workout-form-card-titles">
                            <h3>EXERCÍCIO</h3>
                            <h3>SETS</h3>
                            <h3>REPETIÇÕES</h3>
                            <h3>CARGA</h3>
                        </div>

                        <div className="gs-workout-form-card-exercise">
                            <FormInput className="gs-form-control" />
                            <FormInput className="gs-form-control" />
                            <FormInput className="gs-form-control" />
                            <FormInput className="gs-form-control" />
                        </div>
                        
                        <button className="gs-btn gs-btn-purple">Adicionar Exercício</button>

                        <div className="gs-workout-form-card-save">
                            <h3>Nome do treino:</h3>
                            <FormInput className="gs-form-control" />
                            <button className="gs-btn gs-btn-purple">Salvar Treino</button>
                        </div>

                    </div>
                </form>

            </section>
        </main>

    );
}