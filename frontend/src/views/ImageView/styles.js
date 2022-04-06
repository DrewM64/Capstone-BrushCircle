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
    }

    return styles;
}

export default createStyles;