import { AxiosRequestConfig } from "axios";
import { requestBackEnd } from "../utils/requests";

export function findWorkoutsByUser()
{
    const config: AxiosRequestConfig = {
        method: "GET",
        url: "/workouts",
        withCredentials: true
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