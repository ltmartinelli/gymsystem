import './styles.css'

type Props = {
    onNextPage: () => void;
}

export default function ButtonNextPage({ onNextPage }: Props)
{
    return (
        <div onClick={() => onNextPage()} className="gs-btn-next-page">Carregar mais</div>
    );
}