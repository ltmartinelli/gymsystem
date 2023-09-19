import { ClientAddressDTO } from "./client-address"
import { Roles } from "./roles"
import { UnitDTO } from "./unit"

export type UserDTO = {
    
        id: number,
        name: string,
        email: string,
        phone: string,
        birthDate: string,
        address: ClientAddressDTO,
        unit: UnitDTO,
        roles: Roles[]
    
}