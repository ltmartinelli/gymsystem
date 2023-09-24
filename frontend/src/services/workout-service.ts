import { AxiosRequestConfig } from "axios";
import { requestBackEnd } from "../utils/requests";
import { WorkoutDTO } from "../models/workout";

export function findWorkoutsByUser()
{
    const config: AxiosRequestConfig = {
        method: "GET",
        url: "/workouts",
        withCredentials: true
    }

    return requestBackEnd(config);
}

export function findById(id: number)
{
    const config: AxiosRequestConfig = {
        method: "GET",
        url: `/workouts/${id}`,
        withCredentials: true
    }

    return requestBackEnd(config);
}

export function insertRequest(obj: WorkoutDTO)
{
    const config: AxiosRequestConfig = {
        method: "POST",
        url: "/workouts",
        withCredentials: true,
        data: obj
    }

    return requestBackEnd(config);
}

export function updateRequest(obj: WorkoutDTO)
{
    const config: AxiosRequestConfig = {
        method: "PUT",
        url: `/workouts/${obj.id}`,
        withCredentials: true,
        data: obj
    }

    return requestBackEnd(config);
}

export function deleteById(id: number)
{
    const config: AxiosRequestConfig = {
        method: "DELETE",
        url: `/workouts/${id}`,
        withCredentials: true,
    }

    return requestBackEnd(config);
}