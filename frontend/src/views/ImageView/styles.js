const createStyles = (options) => {
    let overlayContainerHeight;

    //style options for the overlay container
    if(options.shrinkOverlay){
        overlayContainerHeight = "10vh";
    }else{
        overlayContainerHeight = "35vh";
    }

    let styles = {
        container: {
            backgroundColor: "backgroundColor1",
            height: "100vh",
        },
        imageContainer: {
            display: "flex",
            justifyContent: "center",
            img: {
                height: "73vh",
                borderRadius: "8px",
                cursor: "grabbing",
            },
        },
        overlayContainer: {
            position: "absolute",
            backgroundColor: "white",
            overflow: "hidden",
            borderTop: "2px solid lightgrey",
            height: overlayContainerHeight,
            width: "100vw",
            bottom: "0",
            transition: "height 0.2s ease-in",
        },
        overlayHeader: {
            display: "flex",
            alignItems: "center",
            padding: "20px",
        },
        authorColumn: {
            display: "flex",
            justifyContent: "end",
            flexGrow: "1",
        },
        detailsContainer: {
            display: "flex",
            height: "100%",
            justifyContent: "space-evenly",
            alignItems: "start",
        },
        dateContainer: {
            display: "flex",
            width: "15vw",
            paddingTop: "15px",
            flexDirection: "column",
            justifyContent: "center",
            alignItems: "center"
        },
        biographyContainer: {
            width: "30vw",
            height: "50%",
            padding: "20px 15px 0 20px",
            textAlign: "center",
            borderRight: "1px solid black",
            borderLeft: "1px solid black"
        },
        attributesContainer: {
            display: "grid",
            paddingTop: "15px",
            gridTemplateColumns: "auto auto",
            columnGap: "25px",
            alignItems: "center",
        },
    }

    return styles;
}

export default createStyles;