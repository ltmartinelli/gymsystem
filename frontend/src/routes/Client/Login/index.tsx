import { useContext, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import FormInput from '../../../components/FormInput/index.tsx';
import * as authService from '../../../services/auth-service.ts';
import { ContextToken } from '../../../utils/context-token.ts';
import * as forms from '../../../utils/forms.ts';
import './styles.css';

export default function Login()
{

    const { setContextTokenPayload } = useContext(ContextToken);

    const navigate = useNavigate();

    const [submitResponseFail, setSubmitResponseFail] = useState(false);

    const [formData, setFormData] = useState<any>({
        username: {
            value: "",
            id: "username",
            name: "username",
            type: "text",
            placeholder: "Email",
            validation: function (value: string)
            {
                return /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(value.toLowerCase());
            },
            message: "Favor informar um email válido",
        },
        password: {
            value: "",
            id: "password",
            name: "password",
            type: "password",
            placeholder: "Senha",
        }
    })

    function handleSubmit(event: any)
    {
        event.preventDefault();

        setSubmitResponseFail(false)

        const formDataValidated = forms.dirtyAndValidateAll(formData);
        if (forms.hasAnyInvalid(formDataValidated))
        {
            setFormData(formDataValidated);
            return;
        }

        authService.loginRequest(forms.toValues(formData))
            .then(response =>
            {
                authService.saveAccessToken(response.data.access_token);
                setContextTokenPayload(authService.getAccessTokenPayload());
                navigate("/cart");
            })
            .catch(() => { setSubmitResponseFail(true) });
    }

    function handleInputChange(event: any)
    {
        const name = event.target.name;
        const value = event.target.value;

        const result = forms.updateAndValidate(formData, name, value);
        setFormData(result);
    }

    function handleTurnDirty(name: string)
    {
        const newFormData = forms.dirtyAndValidate(formData, name);
        setFormData(newFormData);
    }

    return (
        <main>
            <section id="login-section" className="gs-container">
                <div className="gs-login-form-container">
                    <form className="gs-card gs-form" onSubmit={handleSubmit}>
                        <h2>Login</h2>
                        <div className="gs-form-controls-container">
                            <div>
                                <FormInput
                                    {...formData.username}
                                    className="gs-form-control"
                                    onChange={handleInputChange}
                                    onTurnDirty={handleTurnDirty}
                                />
                                <div className="gs-form-error">{formData.username.message}</div>
                            </div>
                            <div>
                                <FormInput
                                    {...formData.password}
                                    onChange={handleInputChange}
                                    className="gs-form-control"
                                    onTurnDirty={handleTurnDirty}
                                />
                            </div>
                        </div>

                        {
                            submitResponseFail &&
                            <div className="gs-form-global-error">
                                Usuário ou senha inválidos
                            </div>
                        }

                        <div className="gs-login-form-buttons gs-mt20">
                            <button type="submit" className="gs-btn gs-btn-blue">Entrar</button>
                        </div>
                    </form>
                </div>
            </section>
        </main>
    );
}