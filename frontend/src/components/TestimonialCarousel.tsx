import { Carousel, Image } from "react-bootstrap";
import styled from "styled-components";
const testimonials = [
  {
    quote: "This app changed how I budget forever.",
    author: "Jane Doe",
    title: "Freelancer",
    avatar: "/images/jane.jpg",
  },
  {
    quote: "Amazing interface and so easy to use!",
    author: "John Smith",
    title: "Project Manager",
    avatar: "/images/john.jpg",
  },
  {
    quote: "I saved $200/month thanks to these insights.",
    author: "Alice Lee",
    title: "Designer",
    avatar: "/images/alice.jpg",
  },
];

const Quote = styled.blockquote`
  font-size: 1.25rem;
  color: #334155;
  margin: 0 0 1rem;
  font-style: italic;
`;

const Author = styled.figcaption`
  font-weight: bold;
  color: #1f2937;
`;

const Title = styled.span`
  font-size: 0.9rem;
  color: #6b7280;
`;

export default function TestimonialCarousel() {
  return (
    <section style={{ background: "#f8fafc", padding: "4rem 0" }}>
      <h2 className="text-center mb-4" style={{ color: "#334155" }}>
        What Our Users Say
      </h2>
      <Carousel indicators={false} controls={true} pause="hover" interval={5000}>
        {testimonials.map((t, idx) => (
          <Carousel.Item key={idx}>
            <figure
              className="d-flex flex-column align-items-center text-center mx-auto"
              style={{ maxWidth: 600 }}
            >
              <Image
                src={t.avatar}
                roundedCircle
                width={80}
                height={80}
                className="mb-3"
              />
              <Quote>“{t.quote}”</Quote>
              <Author>{t.author}</Author>
              <Title>{t.title}</Title>
            </figure>
          </Carousel.Item>
        ))}
      </Carousel>
    </section>
  );
}
