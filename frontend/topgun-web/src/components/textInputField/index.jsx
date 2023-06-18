import "./TextInputField.css"

const TextInputField = (props) => {
    return (
        <div className="textInputField">


            <label>{props.label}</label>
            <input required={props.necessary} placeholder={props.placeholder} value={props.value} onChange={props.onChange} />

        </div>
    )
}

export default TextInputField