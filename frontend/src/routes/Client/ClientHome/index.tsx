import { Outlet } from "react-router-dom";
import ClientHeader from "../../../components/ClientHeader";

export default function ClientHome()
{
    return (
        <>
            <ClientHeader/>
            <Outlet />
        </>
    )
}