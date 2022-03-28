const styles = {
    container: {
        // display: "flex",
        width: "100%",
        height: "557px",
        overflow: "hidden",
    },
    content: {
        width: "75%",
        height: "100%",
        overflowY: "scroll",
        transition: "width 0.3s",
    },
    contentExpanded: {
        overflowY: "scroll",
        width: "100%",
        height: "100%",
        transition: "width 0.3s",
    },
    rightSidebar: {
        position: "relative",
        right: "0",
        width: "25%",
        height: "100%",
        transition: "right 0.4s",
    },
    rightSidebarClosed: {
        position: "relative",
        right: "-300px",
        width: "0px",
        height: "100%",
    },
}

export default styles;