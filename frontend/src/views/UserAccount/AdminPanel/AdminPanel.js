import { Box, TextField, InputAdornment, Button, IconButton, Typography, TableContainer, Paper, Table, TableHead, TableRow, Tab, TableCell, TableBody, Stack } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import EditOutlinedIcon from '@mui/icons-material/EditOutlined';
import DeleteOutlineOutlinedIcon from '@mui/icons-material/DeleteOutlineOutlined';
import ArrowBackOutlinedIcon from '@mui/icons-material/ArrowBackOutlined';
import React, { useState } from 'react'
import PersonAddAltIcon from '@mui/icons-material/PersonAddAlt';

import makeStyles from './styles'
import AdminGalleryItem from './AdminGalleryItem/AdminGalleryItem';

function AdminPanel(props) {
    const [isUserSelected, setIsUserSelected] = useState(false);
    const [selectedIndex, setSelectedIndex] = useState(null);
    const [isSidebarOpen, setIsSidebarOpen] = useState(false);
    const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]
    const { value, index } = props;
    const styles = makeStyles(value, index, isUserSelected, isSidebarOpen);

    const onTableRowClicked = (event) => {
        setIsUserSelected(true);
    }

    const onMainBackButtonClicked = (event) => {
        setIsUserSelected(false);
    }

    const onGalleryItemClicked = (index) => {
        setSelectedIndex(index);

        //if being deselected then the sidebar should close
        if (index == null) {
            setIsSidebarOpen(false);
        } else {
            setIsSidebarOpen(true)
        }
    }

    return (
        <Box sx={styles.container}>
            <Box sx={styles.searchContainer}>
                <Box sx={styles.adminHeader}>
                    <TextField
                        sx={styles.searchField}
                        placeholder="Search"
                        size='small'
                        InputProps={{
                            startAdornment: <InputAdornment position='start'><SearchIcon /></InputAdornment>
                        }}
                    />
                    <Button variant='contained' >Search</Button>
                    <Button variant='contained' sx={styles.addUserButton}><PersonAddAltIcon /></Button>
                </Box>
                <hr id="searchHR" />
                <Box sx={styles.resultsContainer}>
                    <Typography>7 Results</Typography>
                    <TableContainer component={Paper}>
                        <Table>
                            <TableHead>
                                <TableRow>
                                    <TableCell>User Email</TableCell>
                                    <TableCell>Account ID</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {nums.map((val, index) => (
                                    <TableRow key={index} sx={styles.tableRow} onClick={onTableRowClicked}>
                                        <TableCell>{val}</TableCell>
                                        <TableCell>{val}</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                </Box>
            </Box>
            <Box sx={styles.selectionContainer}>
                <Box sx={styles.leftInfoContainer}>
                    <Button variant='contained' onClick={onMainBackButtonClicked}>Back</Button>
                    <hr id='selectionHR' />
                    <Typography>User username's products</Typography>
                    <Box sx={styles.mediaContainer}>
                        {nums.map((val, arrayIndex) => {
                            return <AdminGalleryItem index={arrayIndex} key={arrayIndex} clickAction={onGalleryItemClicked} currentIndex={selectedIndex} />
                        })}
                    </Box>
                </Box>
                <Box sx={styles.rightSidebarContainer}>
                    <Box id="actionBar" sx={styles.actionBar} >
                        <Stack direction="row"  >
                            <IconButton >
                                <ArrowBackOutlinedIcon />
                            </IconButton>
                            <IconButton sx={styles.editButton}>
                                <EditOutlinedIcon />
                            </IconButton >
                            <IconButton>
                                <DeleteOutlineOutlinedIcon />
                            </IconButton>
                        </Stack>
                    </Box>
                    <Box sx={styles.userInfoContainer}>
                        <Typography>Username</Typography>
                        <Typography align='right'>fantasticguy@gmail.com</Typography>
                        <Typography>First Name</Typography>
                        <Typography align='right'>Harry</Typography>
                        <Typography>Last Name</Typography>
                        <Typography align='right'>Potter</Typography>
                        <Typography>Phone</Typography>
                        <Typography align='right'>1-800-Not-Here</Typography>
                        <Typography>Address</Typography>
                        <Typography align='right'>2442 Blueberry Lane</Typography>
                        <Typography>State</Typography>
                        <Typography align='right'>CA</Typography>
                        <Typography>Patreon</Typography>
                        <Typography align='right'>hpotter@patreon</Typography>
                        <Typography>Cashapp</Typography>
                        <Typography align='right'>$spellcaster26</Typography>
                        <Typography>Role</Typography>
                        <Typography align='right'>Admin</Typography>
                        <Typography>Title</Typography>
                        <Typography align='right'>Grandmaster</Typography>
                        <Typography>Biography</Typography>
                        <Typography>Loren ipsum something something description for this nv I want t
                            piece of work made by that guy from that place called edfo be the
                            by the name in the event of something lorem lorem alr e very best
                            ight lets end this</Typography>
                    </Box>
                </Box>
            </Box>
        </Box>
    )
}

export default AdminPanel