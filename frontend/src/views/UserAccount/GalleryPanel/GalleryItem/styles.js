const styles = {
    container: {
        width: "100px",
        height: "100px",
        backgroundColor: 'primaryButtonColor',
        cursor: "grab",
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
        border: "5px solid #BFDBDE",
    }
}

export default styles;