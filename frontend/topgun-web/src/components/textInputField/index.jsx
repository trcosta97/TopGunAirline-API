import "./TextInputField.css"

const TextInputField = (props) => {
    return (
        <div>
                    <div className="textInputField">


            <label>{props.label}</label>
            <input required={props.necessary} placeholder={props.placeholder} value={props.value} onChange={props.onChange} />

        </div>
        </div>

    )
}

export default TextInputField