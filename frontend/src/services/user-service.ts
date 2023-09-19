import { AxiosRequestConfig } from "axios";
import { requestBackEnd } from "../utils/requests";

export function findMe()
{
    const config: AxiosRequestConfig = {
        method: "GET",
        url: "/users/me",
        withCredentials: true
    }

    return requestBackEnd(config);
}