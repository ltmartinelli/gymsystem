import { useNavigate, useParams } from "react-router-dom";
import FormInput from "../../../../components/FormInput";
import './styles.css'
import { ExerciseDTO } from "../../../../models/exercise";
import { useState } from "react";
import *  as forms from '../../../../utils/forms.ts'

export default function WorkoutForm()
{

    const params = useParams();

    const navigate = useNavigate();

    const isEditing = params.productId !== 'create';

    const [exercise, setExercise] = useState<any>({ name: "", sets: "", reps: "", weight: "" })

    const [formData, setFormData] = useState<any>({
        name: {
            value: "",
            id: "name",
            name: "name",
            type: "text",
            placeholder: "Nome",
            validation: function (nameValue: string) { return nameValue.length >= 3 && nameValue.length <= 80; },
            message: "Favor informar um nome entre 3 e 80 caracteres."
        },
        exercises: {
            value: [],
            id: "exercises",
            name: "exercises",
            placeholder: "Exercícios",
            validation: function (exerciseValue: ExerciseDTO[]) { return exerciseValue.length > 0 },
            message: "Favor criar ao menos um exercício para este treino."
        }
    })

    function handleInputChange(event: any)
    {
        const name = event.target.name;
        const value = event.target.value;

        const result = forms.updateAndValidate(formData, name, value);
        setFormData(result);
    }

    function handleTurnDirty(name: string)
    {
        const newFormData = forms.dirtyAndValidate(formData, name);
        setFormData(newFormData);
    }


    function handleExerciseChange(event: any)
    {
        const name = event.target.name;
        const value = event.target.value;
        setExercise({ ...exercise, [name]: value })
    }

    function handleExerciseTurnDirty(name: string)
    {
        //EXERCISE VALIDATION
    }


    function handleSubmit(event: any)
    {


        event.preventDefault();

        const requestBody = forms.toValues(formData);

        console.log(requestBody)

        //if (isEditing) { requestBody.id = params.productId; }


        /*
        const request = isEditing ?
            productService.updateRequest(requestBody)
            :
            productService.insertRequest(requestBody)
    
        request
            .then(() => { navigate("/admin/products") })
            .catch(error =>
            {
                const newInputs = forms.setBackendErrors(formData, error.response.data.errors);
                setFormData(newInputs);
            })
            */
    }

    function handleAddExercise() {

        const updatedExercises = [...formData.exercises.value];
      
        updatedExercises.push(exercise);
      
        setFormData({
          ...formData,
          exercises: {
            ...formData.exercises,
            value: updatedExercises,
          },
        });

        console.log(formData)
      }

    return (

        <main className="gs-container">
            <section className="gs-workout-form-section">
                <form className="gs-form" onSubmit={handleSubmit}>
                    {isEditing ? <h1>NOVO TREINO</h1> : <h1>EDITAR</h1>}
                    <div className="gs-workout-form-card">

                        <div className="gs-workout-form-card-titles">
                            <h3>EXERCÍCIO</h3>
                            <h3>SETS</h3>
                            <h3>REPETIÇÕES</h3>
                            <h3>CARGA</h3>
                        </div>

                        <div className="gs-workout-form-card-exercises-list">
                            <div className="gs-workout-form-card-exercise">
                                <FormInput name="name" onTurnDirty={handleExerciseTurnDirty} onChange={handleExerciseChange} className="gs-form-control" />
                                <FormInput name="sets" onTurnDirty={handleExerciseTurnDirty} onChange={handleExerciseChange} className="gs-form-control" />
                                <FormInput name="reps" onTurnDirty={handleExerciseTurnDirty} onChange={handleExerciseChange} className="gs-form-control" />
                                <FormInput name="weight" onTurnDirty={handleExerciseTurnDirty} onChange={handleExerciseChange} className="gs-form-control" />
                                <button onClick={handleAddExercise} className="gs-btn gs-btn-purple" type="button">ADICIONAR EXERCÍCIO</button>
                            </div>
                        </div>

                        <div className="gs-workout-form-card-save">
                            <h3>NOME DO TREINO:</h3>
                            <FormInput
                                {...formData.name}
                                className="gs-form-control"
                                onTurnDirty={handleTurnDirty}
                                onChange={handleInputChange}
                            />
                            <button type="submit" className="gs-btn gs-btn-purple">SALVAR TREINO</button>
                        </div>

                    </div>
                </form>

            </section>
        </main>

    );
}