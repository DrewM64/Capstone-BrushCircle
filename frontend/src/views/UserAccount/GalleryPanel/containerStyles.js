/* Creating this custom style file because we need to enable/disable the display of the container based off
wether the current index is appropriate or not. this is done this way because the prop value 'hiiden'
 of the component gets overrided  by the styles being passed to the element 'display: flex' */

const createStyles = (displayBool) => {
    var displayValue = displayBool ? "none" : "flex";
    var styles = {
        display: displayValue,
        width: "100%",
        height: "557px",
        overflow: "hidden",
    }

    return styles
}

export default createStyles;