const styles = {
    container: {
        width: "150px",
        height: "150px",
        backgroundColor: 'black',
        cursor: "grab",
        overflow: "hidden",
        borderRadius: "5px",
        border: "2px solid lightgrey",
        [':hover']: {
            border: "3px solid blue",
            backgroundColor: "galleryItemHoverColor",
            transition: "all 0.1s 0.01s",
        },
    },
    selected: {
        width: "150px",
        height: "150px",
        backgroundColor: 'primaryButtonColor',
        cursor: "grab",
        borderRadius: "5px",
        overflow: "hidden",
        border: "5px solid #1AC447",
    }
}

export default styles;