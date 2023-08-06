import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';

function Navigation() {
  return (
    <Navbar className="bg-body-secondary pb-3">
      <Container>
        <Navbar.Brand href="/">
            <img
              src="/images/logo.png"
              width="30"
              height="30"
              className="d-inline-block align-top"
              alt="Db logo"
            /> {' '} Booking App
          </Navbar.Brand>
        <Navbar.Toggle />
        <Navbar.Collapse className="justify-content-end">
        <Nav className="m">
            <Nav.Link href="/Login">Logout</Nav.Link>
          </Nav>
          <Navbar.Text>
            Signed in as: <a href="#login">Raghavendra T</a>
          </Navbar.Text>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Navigation;