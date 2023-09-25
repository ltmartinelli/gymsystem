import { useNavigate, useParams } from "react-router-dom";
import FormInput from "../../../../components/FormInput";
import './styles.css'
import { ExerciseDTO } from "../../../../models/exercise";
import { useEffect, useState } from "react";
import *  as forms from '../../../../utils/forms.ts'
import * as workoutService from '../../../../services/workout-service.ts'

export default function WorkoutForm()
{

    const params = useParams();

    const navigate = useNavigate();

    const isEditing = params.workoutId !== 'create';

    const [workout, setWorkout] = useState<ExerciseDTO[]>([]);

    const [exercise, setExercise] = useState<ExerciseDTO>({ name: "", sets: 0, reps: 0, weight: 0 })

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

    useEffect(() =>
    {
        if (isEditing)
        {
            workoutService.findById(Number(params.workoutId))
                .then(response =>
                {
                    setFormData(forms.updateAll(formData, response.data));
                    setWorkout(response.data.exercises)
                });
        }
    }, [])

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
        if (name === "name")
        {
            return;
        } else if (name === "sets" || name === "reps" || name === "weight")
        {
            const value = exercise[name];
            if (isNaN(value))
            {
                console.error(`Invalid value for ${name}: ${value}`);
            }
        }
    }


    function handleSubmit(event: any)
    {


        event.preventDefault();

        const requestBody = forms.toValues(formData);

        if (isEditing) { requestBody.id = params.workoutId; }

        const request = isEditing ?
            workoutService.updateRequest(requestBody)
            :
            workoutService.insertRequest(requestBody)

        request
            .then(() => { navigate("/workouts") })
            .catch(error =>
            {
                const newInputs = forms.setBackendErrors(formData, error.response.data.errors);
                setFormData(newInputs);
            })

    }

    function handleAddExercise()
    {

        const updatedExercises = [...formData.exercises.value];
        const updatedWorkout = [...workout];

        updatedExercises.push(exercise);
        updatedWorkout.push(exercise);

        setWorkout(updatedWorkout)

        setFormData({
            ...formData,
            exercises: {
                ...formData.exercises,
                value: updatedExercises,
            },
        });

    }

    type Props = {
        exerciseIndex: number,
        onDeleteExerciseClick: (exerciseIndex: number) => void
    }

    function DeleteButton({ exerciseIndex, onDeleteExerciseClick }: Props)
    {
        return (<td onClick={() => onDeleteExerciseClick(exerciseIndex)} className="gs-delete-btn">X</td>);
    }

    function handleDeleteExerciseClick(index: number)
    {
        const updatedExercises = [...formData.exercises.value];
        const updatedWorkout = [...workout];

        updatedExercises.splice(index, 1);
        updatedWorkout.splice(index, 1);

        setWorkout(updatedWorkout)

        setFormData({
            ...formData,
            exercises: {
                ...formData.exercises,
                value: updatedExercises,
            },
        });
    }

    return (

        <main className="gs-container">
            <section className="gs-workout-form-section">
                <form className="gs-form" onSubmit={handleSubmit}>
                    {!isEditing ? <h1>NOVO TREINO</h1> : <h1>EDITAR</h1>}
                    <div className="gs-workout-form-card">

                        <div className="gs-workout-form-card-titles">
                            <h3>EXERCÍCIO</h3>
                            <h3>SETS</h3>
                            <h3>REPETIÇÕES</h3>
                            <h3>CARGA</h3>
                        </div>

                        <div className="gs-workout-form-card-exercises-list">
                            <div className="gs-workout-form-card-exercise">
                                <FormInput name="name" onTurnDirty={handleExerciseTurnDirty} onChange={handleExerciseChange} className="gs-form-control" placeholder="Nome" />
                                <FormInput name="sets" onTurnDirty={handleExerciseTurnDirty} onChange={handleExerciseChange} className="gs-form-control" placeholder="Digite um número" />
                                <FormInput name="reps" onTurnDirty={handleExerciseTurnDirty} onChange={handleExerciseChange} className="gs-form-control" placeholder="Digite um número" />
                                <FormInput name="weight" onTurnDirty={handleExerciseTurnDirty} onChange={handleExerciseChange} className="gs-form-control" placeholder="Digite um número" />
                                <button onClick={handleAddExercise} className="gs-btn gs-btn-purple" type="button">ADICIONAR EXERCÍCIO</button>
                            </div>
                        </div>

                        <table className="gs-workout-table">
                            <thead>
                                <tr>
                                    <th>Exercício</th>
                                    <th>Sets</th>
                                    <th>Repetições</th>
                                    <th>Carga</th>
                                </tr>
                            </thead>
                            <tbody>

                                {
                                    workout.map((e, index) =>
                                        <tr key={index}>
                                            <td>{e.name}</td>
                                            <td>{e.sets}</td>
                                            <td>{e.reps}</td>
                                            <td>{e.weight} kg</td>
                                            <DeleteButton exerciseIndex={index} onDeleteExerciseClick={handleDeleteExerciseClick} />
                                        </tr>
                                    )
                                }

                            </tbody>
                        </table>

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