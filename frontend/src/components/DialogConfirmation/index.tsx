type Props = {
    id: number,
    message: string,
    onDialogAnswer: (answer: boolean, id: number) => void,
}

export default function DialogConfirmation({ message, onDialogAnswer, id }: Props)
{
    return (
        <div onClick={() => onDialogAnswer(false, id)} className="gs-dialog-bg">
            <div onClick={(e) => e.stopPropagation()} className="gs-dialog-box">
                <h2>{message}</h2>
                <div className="gs-dialog-btn-container">
                    <div onClick={() => onDialogAnswer(false, id)} >
                        <button className="gs-dialog-btn-no">Não</button>
                    </div>
                    <div onClick={() => onDialogAnswer(true, id)}>
                        <button className="gs-dialog-btn-yes">Sim</button>
                    </div>
                </div>
            </div>
        </div>
    )
}