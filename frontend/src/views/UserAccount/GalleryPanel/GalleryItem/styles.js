const styles = {
    container: {
        width: "150px",
        height: "150px",
        backgroundColor: 'black',
        cursor: "grab",
        overflow: "hidden",
        borderRadius: "5px",
        [':hover'] : {
            backgroundColor: "galleryItemHoverColor"
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