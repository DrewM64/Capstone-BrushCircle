const styles = {
    content: {
        width: "70%",
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
        width: "30%",
        height: "100%",
        transition: "right 0.4s",
    },
    rightSidebarClosed: {
        position: "relative",
        right: "-300px",
        width: "0px",
        height: "100%",
    },
    imagesList: {
        display: "flex",
        flexWrap: "wrap",
        justifyContent: "center",
        columnGap: "20px",
        rowGap: "20px",
        padding: "30px",
    },
    uploadButton: {
        margin: "20px 0 20px 0"
    },
    actionBar: {
        width: "50px"
    }
}

export default styles;