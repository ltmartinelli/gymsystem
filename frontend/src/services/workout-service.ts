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