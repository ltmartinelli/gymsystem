import { useState } from 'react';
import './styles.css';

type Props = {
    onSearch: (text: string) => void;
}

export default function SearchBar({ onSearch }: Props)
{
    const [text, setText] = useState("");

    function handleSubmit(event: any)
    {
        event.preventDefault();
        onSearch(text);
    }

    function handleChange(event: any)
    {
        setText(event.target.value);
    }

    function handleResetClick()
    {
        setText("");
        onSearch(text);
    }

    return (
        <form className="gs-search-bar" onSubmit={handleSubmit}>
            <button type="submit">🔎︎</button>
            <input onChange={handleChange} value={text} type="text" placeholder="Nome" />
            <button type="reset" onClick={handleResetClick}>🗙</button>
        </form>
    );
}