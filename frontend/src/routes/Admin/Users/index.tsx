import { useState } from 'react';
import SearchBar from '../../../components/SearchBar';
import './styles.css'

export default function Users()
{

    function handleSearch(searchText: string)
    {
        //setUsers([]);
        //setQueryParams({ ...queryParams, page: 0, name: searchText });
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
                    <tr>
                        <td>Fulano</td>
                        <td>fulano@gmail.com</td>
                        <td>unidade</td>
                    </tr>
                    <tr>
                        <td>Fulano</td>
                        <td>fulano@gmail.com</td>
                        <td>unidade</td>
                    </tr>
                    <tr>
                        <td>Fulano</td>
                        <td>fulano@gmail.com</td>
                        <td>unidade</td>
                    </tr>
                    <tr>
                        <td>Fulano</td>
                        <td>fulano@gmail.com</td>
                        <td>unidade</td>
                    </tr>
                </tbody>
            </table>
        </section>
    );
}