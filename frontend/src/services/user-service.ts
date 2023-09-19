import { AxiosRequestConfig } from "axios";
import { requestBackEnd } from "../utils/requests";

export function findPageRequest(page: number, name: string, size = 12, sort = "name")
{
    const config: AxiosRequestConfig = {
        withCredentials : true,
        method: "GET",
        url: "/users",
        params: {
            page,
            name,
            size,
            sort,
        }
    }

    return requestBackEnd(config);
}

export function findMe()
{
    const config: AxiosRequestConfig = {
        method: "GET",
        url: "/users/me",
        withCredentials: true
    }

    return requestBackEnd(config);
}