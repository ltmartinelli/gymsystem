import { useEffect, useState } from 'react';
import SearchBar from '../../../components/SearchBar';
import './styles.css'
import ButtonNextPage from '../../../components/ButtonNextPage';
import { UserMinDTO } from '../../../models/user-min';
import * as userService from '../../../services/user-service.ts';


type QueryParams = {
    page: number;
    name: string;
}

export default function Users()
{

    const [isLastPage, setIsLastPage] = useState(false);

    const [users, setUsers] = useState<UserMinDTO[]>([]);

    const [queryParams, setQueryParams] = useState<QueryParams>(
        {
            page: 0, name: ""
        });

    useEffect(() =>
    {
        userService.findPageRequest(queryParams.page, queryParams.name).then(response =>
        {
            const nextPage = response.data.content;
            setUsers(users.concat(nextPage));
            setIsLastPage(response.data.last);
        });

    }, [queryParams]);

    function handleSearch(searchText: string)
    {
        setUsers([]);
        setQueryParams({ ...queryParams, page: 0, name: searchText });
    }

    function handleNextPageClick()
    {
        setQueryParams({ ...queryParams, page: queryParams.page + 1 });
    }

    return (
        <section className="gs-users-section">
            <SearchBar onSearch={(handleSearch)} />

            <table className="gs-users-table">
                <thead>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Unidade</th>
                </thead>
                <tbody>
                    {
                        users.map(
                            user =>
                                <tr key={user.id}>
                                    <td>{user.name}</td>
                                    <td>{user.email}</td>
                                    <td>{user.unitName}</td>
                                </tr>
                        )
                    }
                </tbody>
            </table>

            {
                !isLastPage &&
                < div onClick={handleNextPageClick}>
                    <ButtonNextPage onNextPage={handleNextPageClick} />
                </div>
            }

        </section>
    );
}