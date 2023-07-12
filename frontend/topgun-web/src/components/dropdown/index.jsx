import { DropdownStyle } from '../../Styled/Dropdown'


const Dropdown = (props) =>{
    return(
        <DropdownStyle>
            <label>{props.label}</label>
            <select value={props.value} onChange={props.onChange} required = {props.necessary} >
                {props.items.map(item =>{
                    return <option key={item}>{item}</option>
                })}
            </select>
        </DropdownStyle>
    )
}

export default Dropdown