const styles = {
    container: {
        width: "100px",
        height: "100px",
        backgroundColor: 'black',
        cursor: "grab",
        overflow: "hidden",
        borderRadius: "5px",
        [':hover'] : {
            backgroundColor: "galleryItemHoverColor"
        },
    },
    selected: {
        width: "100px",
        height: "100px",
        backgroundColor: 'primaryButtonColor',
        cursor: "grab",
        borderRadius: "5px",
        overflow: "hidden",
        border: "5px solid #BFDBDE",
    }
}

export default styles;